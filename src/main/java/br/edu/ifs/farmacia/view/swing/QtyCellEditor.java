package br.edu.ifs.farmacia.view.swing;

import br.edu.ifs.farmacia.model.Venda;
import br.edu.ifs.farmacia.util.EventCellInputChange;
import br.edu.ifs.farmacia.util.ProdutoNaoPodeSerVendidoException;
import java.awt.Component;
import java.text.DecimalFormat;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.text.DefaultFormatter;

public class QtyCellEditor extends DefaultCellEditor {

    private EventCellInputChange event;
    private JSpinner input;

    private JTable table;
    private int row;
    private Venda item;

    public QtyCellEditor(EventCellInputChange event) {
        super(new JCheckBox());
        this.event = event;
        input = new JSpinner();
        SpinnerNumberModel numberModel = (SpinnerNumberModel) input.getModel();
        numberModel.setMinimum(1);
        JSpinner.NumberEditor editor = (JSpinner.NumberEditor) input.getEditor();
        DefaultFormatter formatter = (DefaultFormatter) editor.getTextField().getFormatter();
        formatter.setCommitsOnValidEdit(true);
        editor.getTextField().setHorizontalAlignment(SwingConstants.CENTER);
        input.addChangeListener((ChangeEvent e) -> {
            inputChange();
        });
    }

    public JSpinner getInput() {
        return input;
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        super.getTableCellEditorComponent(table, value, isSelected, row, column);
        this.table = table;
        this.row = row;
        this.item = (Venda) table.getValueAt(row, 0);
        ((SpinnerNumberModel) this.input.getModel()).setMaximum(item.getProduto().getQuantidadeEstoque());
        int qty = Integer.parseInt(value.toString());
        input.setValue(qty);
        input.setEnabled(false);
        enable();
        return input;
    }

    private void enable() {
        new Thread(() -> {
            try {
                Thread.sleep(100);
                input.setEnabled(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @Override
    public Object getCellEditorValue() {
        return input.getValue();
    }

    private void inputChange() {
        int qty = Integer.parseInt(input.getValue().toString());
        if (qty != item.getQuantidade()) {
            DecimalFormat df = new DecimalFormat("#,##0.##");
            try {
                item.setQuantidade(qty);
            } catch (ProdutoNaoPodeSerVendidoException e) {
                System.err.println(e.getMessage());
            }
            item.setTotal(item.getValorVendido()* qty);
            table.setValueAt("$ " + df.format(item.getTotal()), row, 7);
            event.inputChanged();
        }
    }
}
