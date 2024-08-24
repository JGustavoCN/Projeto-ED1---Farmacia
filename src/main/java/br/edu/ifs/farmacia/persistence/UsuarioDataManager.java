package br.edu.ifs.farmacia.persistence;

import br.edu.ifs.farmacia.repository.UsuarioRepository;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Aluno
 */
public class UsuarioDataManager {

    private static final String FILE_NAME = "serialized_objects/usuarios.dat";

    public static void salvar(UsuarioRepository usuarioRepository) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(getFilePath(FILE_NAME)))) {
            oos.writeObject(usuarioRepository);
             System.out.println("Usuários salvos com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static UsuarioRepository carregar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(getFilePath(FILE_NAME)))) {
            UsuarioRepository loadedRepository = (UsuarioRepository) ois.readObject();
            br.edu.ifs.farmacia.model.login.Administrador adm = new br.edu.ifs.farmacia.model.login.Administrador("admin", "admin");
            if (!loadedRepository.buscarTodos().contem(adm)) {
                loadedRepository.adicionar(adm);
            }
            return loadedRepository;
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getFilePath(String fileName) {
        // Acessa o arquivo a partir do classpath
        return new File("src/main/resources/" + fileName).getAbsolutePath();
    }
}

