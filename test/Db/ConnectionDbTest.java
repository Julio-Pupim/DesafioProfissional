package Db;


import Db.ConnectionDb;
import org.bson.Document;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConnectionDbTest {

    private ConnectionDb connectionDb;

    @BeforeEach
    public void setup() {
        connectionDb = new ConnectionDb();
        // Estabelecer a conexão com o MongoDB para fins de teste
        connectionDb.Conexao("mongodb://localhost:27017", "testdb", "testcollection");
    }

    @Test
    public void testInsertUser_Successful() {
        // Criar um objeto do tipo Document com os dados do usuário a ser inserido
        Document user = new Document("nome", "Nome do Usuário")
                .append("senha", "senha123");


        // Inserir o usuário e verificar se a inserção foi bem-sucedida
        connectionDb.Insert(user);

        // Realizar uma consulta para verificar se o usuário foi inserido corretamente
        Document insert = null;
        try {
            insert = connectionDb.findUser("Nome do Usuário", "senha123");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Verificar se o usuário inserido é igual ao usuário retornado na consulta
        //Assertions.assertEquals(user, insertedUser);
    }

    @Test
    public void testFindUser_UserNotFoundException() {
        // Tentar encontrar um usuário que não existe
        Assertions.assertThrows(Exception.class, () -> {
            connectionDb.findUser("Usuário Inexistente", "senha123");
        });
    }

    // Outros testes podem ser adicionados para verificar diferentes cenários e funcionalidades

    // ...
}
