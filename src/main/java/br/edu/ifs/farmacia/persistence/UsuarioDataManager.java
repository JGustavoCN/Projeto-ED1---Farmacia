package br.edu.ifs.farmacia.persistence;

import br.edu.ifs.farmacia.repository.UsuarioRepository;

import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Classe para gerenciar a persistência de dados de usuários.
 */
public class UsuarioDataManager {

    private static final String RESOURCE_DIR = "src/main/resources/serialized_objects/";
    private static final String FILE_NAME = "usuarios.dat";

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
     * Salva o repositório de usuários no arquivo especificado.
     *
     * @param usuarioRepository O repositório de usuários a ser salvo.
     */
    public static void salvar(UsuarioRepository usuarioRepository) {
        String filePath = getFilePath();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(usuarioRepository);
            JOptionPane.showMessageDialog(null, "Usuários salvos com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar usuários: " + e.getMessage(),
                    "Erro de Salvamento", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Carrega o repositório de usuários a partir do arquivo especificado.
     *
     * @return O repositório de usuários carregado, ou um novo repositório se
     * houver erro.
     */
    public static UsuarioRepository carregar() {
        String filePath = getFilePath();
        File file = new File(filePath);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                UsuarioRepository loadedRepository = (UsuarioRepository) ois.readObject();
                br.edu.ifs.farmacia.model.login.Administrador adm = new br.edu.ifs.farmacia.model.login.Administrador("admin", "admin");
                if (!loadedRepository.buscarTodos().contem(adm)) {
                    loadedRepository.adicionar(adm);
                }
                return loadedRepository;
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao carregar usuários: " + e.getMessage(),
                        "Erro de Carregamento", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            try (InputStream inputStream = UsuarioDataManager.class.getClassLoader().getResourceAsStream("serialized_objects/" + FILE_NAME)) {
                if (inputStream != null) {
                    try (ObjectInputStream ois = new ObjectInputStream(inputStream)) {
                        return (UsuarioRepository) ois.readObject();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Arquivo de usuários não encontrado.",
                            "Arquivo Não Encontrado", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao carregar usuários do JAR: " + e.getMessage(),
                        "Erro de Carregamento do JAR", JOptionPane.ERROR_MESSAGE);
            }
        }
        return UsuarioRepository.getInstance(); // Retorna um novo repositório se houver erro
    }
}
