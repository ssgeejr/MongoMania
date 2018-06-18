package online.ioexcept;

import java.net.UnknownHostException;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

// https://github.com/mongolab/mongodb-driver-examples/blob/master/java/JavaSimpleExample.java
// http://www.javaroots.com/2015/05/mongodb-3-with-java.html
// http://mongodb.github.io/mongo-java-driver/3.4/driver/getting-started/quick-start/

public class MongoConnectionmanagerAdvanced {
	private MongoClient mongoClient = null;
//	private MongoDatabase mongoDB = null;
	private MongoClientURI connMan = null;
// 0 = non-Docker, 1 = Docker with linked container named 'mongo'
	private final String[] connectionType = {"localhost","mongo"};
	
	public MongoConnectionmanagerAdvanced(String uname, String pword, String host, String dbname) throws Exception{
		connMan = new MongoClientURI("mongodb://" + uname + ":" + pword + "@" + host + ":27017/" + dbname);
	}

	public MongoConnectionmanagerAdvanced(String uname, String pword, String host, int port, String dbname) throws Exception{
		connMan = new MongoClientURI("mongodb://" + uname + ":" + pword + "@" + host + ":" + port + "/" + dbname);
	}
	
	public MongoConnectionmanagerAdvanced(String uname, String pword, String host) throws Exception{
		connMan = new MongoClientURI("mongodb://" + uname + ":" + pword + "@localhost:27017");
	}
	
	public MongoConnectionmanagerAdvanced(String dbserver, int port) throws Exception{
		mongoClient = new MongoClient( dbserver, port );
	}
	
	public MongoDatabase getDB() throws Exception{
		return mongoClient.getDatabase(connMan.getDatabase());
	}
	
	public MongoDatabase getDB(String dbname) throws Exception{
		return mongoClient.getDatabase(dbname);
	}

}
/*
//To directly connect to a single MongoDB server (note that this will not auto-discover the primary even
//if it's a member of a replica set:
MongoClient mongoClient = new MongoClient();
//or
MongoClient mongoClient = new MongoClient( "localhost" );
//or
MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
//or, to connect to a replica set, with auto-discovery of the primary, supply a seed list of members
MongoClient mongoClient = new MongoClient(Arrays.asList(new ServerAddress("localhost", 27017),
                                   new ServerAddress("localhost", 27018),
                                   new ServerAddress("localhost", 27019)));

DB db = mongoClient.getDB( "mydb" );
*/