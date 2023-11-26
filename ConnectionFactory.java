import java.io.FileInputStream;
import java.sql.DriverManager;
import java.io.File;
import java.util.Properties;
import java.nio.file.Paths;

public class ConnectionFactory {
  private static Properties properties;
  static{
    try{
      properties = new Properties();

      var root = Thread.currentThread().getContextClassLoader().getResource("").getPath();
      properties.load(new FileInputStream(new File(root + "conf.properties")));
      
    }
    catch(Exception e){
      e.printStackTrace();
      System.exit(1);
    }
  }

  public static java.sql.Connection conectar () throws Exception{
    String host = properties.getProperty("DB_HOST");
    String port = properties.getProperty("DB_PORT");
    String name = properties.getProperty("DB_NAME");
    String user = properties.getProperty("DB_USER");
    String password = properties.getProperty("DB_PASSWORD");
    String s = String.format(
      "jdbc:postgresql://%s:%s/%s",
      host, port, name
    );
    var conexao = DriverManager.getConnection(s, user, password);
    return conexao;

  }
}
