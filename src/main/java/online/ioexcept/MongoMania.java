package online.ioexcept;



public class MongoMania extends MongoConnectionmanagerAdvanced{

	public MongoMania() throws Exception{
		super("name","password","brownbag");
	}

	public static void main(String[] args) {
		try {
			System.out.println("xxxxx");
			new MongoMania();
			System.out.println("xxxxx");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
