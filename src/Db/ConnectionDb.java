package Db;

import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class ConnectionDb {
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    
    public void Conexao(String connectionString,String databaseName, String collectionName)  {
        mongoClient = MongoClients.create (connectionString);
        database = mongoClient.getDatabase(databaseName);
        collection = database.getCollection(collectionName);
 }
 public void Close(){
     mongoClient.close();
 }
 
 public void Insert(Document document){
     collection.insertOne(document);
 }
 
 public void Delete(Document document){
    collection.deleteOne(document);
 }
 
 public void Update(Document filter, Document update){
    collection.updateOne(filter, new Document("$set", update));
 }
 
 public Document findUser(String usuario, String senha) throws Exception{
     Document query = new Document("nome",usuario).append("senha", senha);
     Document user = collection.find(query).first();
        if (user == null) {
            throw new Exception("Usuário não encontrado");
        }
        return user;
 }
 public Document findCadastro(String campo, String valor) throws Exception{
     Document query = new Document(campo,valor);
     Document cadastro= collection.find(query).first();
     if(cadastro == null){
         throw new Exception("Cadastro Não encontrado");
     }
     return cadastro;
 }
}
