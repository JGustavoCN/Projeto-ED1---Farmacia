package br.edu.ifs.farmacia.persistence;

import br.edu.ifs.farmacia.repository.ProdutoRepository;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ProdutoDataManager {

    private static final String FILE_NAME = "serialized_objects/produtos.dat";

    public static void salvar(ProdutoRepository produtoRepository) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(getFilePath(FILE_NAME)))) {
            oos.writeObject(produtoRepository);
            System.out.println("Produtos salvos com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ProdutoRepository carregar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(getFilePath(FILE_NAME)))) {
            return (ProdutoRepository) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null; // Retorna um novo repositório se houver erro
    }

    private static String getFilePath(String fileName) {
        return new File("src/main/resources/" + fileName).getAbsolutePath();
    }
}
