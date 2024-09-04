package br.edu.ifs.farmacia.persistence;

import br.edu.ifs.farmacia.repository.VendaRepository;

import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Classe para gerenciar a persistência de dados de vendas.
 */
public class VendaDataManager {

    private static final String RESOURCE_DIR = "src/main/resources/serialized_objects/";
    private static final String FILE_NAME = "vendas.dat";

    private static String getFilePath() {
        File dir;
        // Verifica se estamos executando na IDE (onde o diretório src/main/resources está disponível)
        if (new File(RESOURCE_DIR).exists()) {
            dir = new File(RESOURCE_DIR);
        } else {
            // Se não estiver na IDE, usa o diretório de execução atual e cria o diretório se não existir
            dir = new File(System.getProperty("user.dir") + File.separator + "serialized_objects");
            if (!dir.exists()) {
                dir.mkdirs(); // Cria o diretório se não existir
            }
        }
        return dir.getAbsolutePath() + File.separator + FILE_NAME;
    }

    /**
     * Salva o repositório de vendas no arquivo especificado.
     *
     * @param vendaRepository O repositório de vendas a ser salvo.
     */
    public static void salvar(VendaRepository vendaRepository) {
        String filePath = getFilePath();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(vendaRepository);
            JOptionPane.showMessageDialog(null, "Vendas salvas com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar vendas: " + e.getMessage(),
                    "Erro de Salvamento", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Carrega o repositório de vendas a partir do arquivo especificado.
     *
     * @return O repositório de vendas carregado, ou um novo repositório se
     * houver erro.
     */
    public static VendaRepository carregar() {
        String filePath = getFilePath();
        File file = new File(filePath);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                return (VendaRepository) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao carregar vendas: " + e.getMessage(),
                        "Erro de Carregamento", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            try (InputStream inputStream = VendaDataManager.class.getClassLoader().getResourceAsStream("serialized_objects/" + FILE_NAME)) {
                if (inputStream != null) {
                    try (ObjectInputStream ois = new ObjectInputStream(inputStream)) {
                        return (VendaRepository) ois.readObject();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Arquivo de vendas não encontrado.",
                            "Arquivo Não Encontrado", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao carregar vendas do JAR: " + e.getMessage(),
                        "Erro de Carregamento do JAR", JOptionPane.ERROR_MESSAGE);
            }
        }
        return VendaRepository.getInstance(); // Retorna um novo repositório se houver erro
    }
}
