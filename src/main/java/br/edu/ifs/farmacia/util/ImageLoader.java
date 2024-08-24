package br.edu.ifs.farmacia.util;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author Aluno
 */
public class ImageLoader {

    private static final String PATH_ICONS = "/imagens/";

    // Cria uma imagem de erro padrão
    private static ImageIcon createErrorIcon() {
        int size = 16; // Tamanho do ícone
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();

        // Ativa antialiasing para suavizar as bordas
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        // Desenhar fundo com gradiente radial
        float[] dist = {0.0f, 0.6f, 1.0f};
        Color[] colors = {new Color(255, 99, 71), new Color(255, 69, 69), new Color(139, 0, 0)};
        RadialGradientPaint radialGradient = new RadialGradientPaint(
            size / 2.0f, size / 2.0f, size / 2.0f,
            dist, colors
        );
        g.setPaint(radialGradient);
        g.fill(new Ellipse2D.Double(0, 0, size, size)); // Desenha o círculo de fundo

        // Cria uma camada para o brilho
        BufferedImage shineLayer = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D gShine = shineLayer.createGraphics();
        gShine.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gShine.setColor(new Color(255, 255, 255, 60)); // Brilho com maior opacidade
        gShine.fill(new Ellipse2D.Double(2, 2, size - 4, size - 4)); // Desenha o brilho
        gShine.dispose();

        // Aplica o brilho usando AlphaComposite
        g.setComposite(AlphaComposite.SrcOver.derive(0.6f)); // Define a opacidade do brilho
        g.drawImage(shineLayer, 0, 0, null);

        // Desenhar X branco com antialiasing
        g.setComposite(AlphaComposite.SrcOver.derive(1.0f)); // Define a opacidade do X
        g.setColor(Color.WHITE);
        g.setStroke(new BasicStroke(2)); // Espessura da linha do X
        int padding = 3; // Espaçamento ajustado para um X mais visível

        // Desenha as linhas do X com melhor visibilidade
        g.drawLine(padding, padding, size - padding - 1, size - padding - 1);
        g.drawLine(size - padding - 1, padding, padding, size - padding - 1);

        g.dispose();
        return new ImageIcon(image);

    }

    // Carrega uma imagem do caminho especificado ou retorna uma imagem de erro
    public static ImageIcon loadImage(String fileName) {
        String path = PATH_ICONS + fileName;
        URL resourceUrl = ImageLoader.class.getResource(path);

        if (resourceUrl == null) {
            System.err.println("Recurso não encontrado: " + path);
            return createErrorIcon();
        }
        return new ImageIcon(resourceUrl);
    }
}
