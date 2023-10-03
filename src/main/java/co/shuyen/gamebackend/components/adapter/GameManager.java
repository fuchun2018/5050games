package co.shuyen.gamebackend.components.adapter;

import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;

import java.time.LocalDateTime;

public class GameManager implements co.shuyen.gamebackend.interfaces.ports.in.IGameManager{

    @Override
    public void CreateGame(String id, LocalDateTime createTime, double currentPrice) {
        // create game info in mongodb
        String uri = "mongodb://localhost:27017";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("fifty-fifty");
            MongoCollection<Document> collection = database.getCollection("games");
            Document game = new Document("_id", id)
                    .append("createTime", createTime)
                    .append("currentPrice", currentPrice);
            collection.insertOne(game);
        }
    }
}
