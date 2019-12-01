package daos;

import com.sun.jdi.connect.Connector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoConcrete implements DaoInterface {
    Connection connection = (Connection) ConnectionFactory.getConnection();

    public Object findById(int id) {


        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE id=" + id);
            if(rs.next())
            {
                Cars car = new Cars();
                car.setId( rs.getInt("id") );
                car.setMake( rs.getString("MAKE") );
                car.setModel( rs.getString("MODEL") );
                car.setColor( rs.getString("COLOR") );
                car.setYear( rs.getInt("YEAR") );
                car.setVin( rs.getString("VIN") );

                return car;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List findAll() {
        try {
            Statement stmt = connection.createStatement();
            String sql;
            sql = "SELECT * FROM CARS;";
            ResultSet rs = null;
            rs = stmt.executeQuery(sql);
            ArrayList<Cars> results = new ArrayList<Cars>();
            while (rs.next()) {
                results.add(new Cars(rs.getInt("id"),
                        rs.getString("MAKE"),
                        rs.getString("MODEL"),
                        rs.getInt("YEAR"),
                        rs.getString("COLOR"),
                        rs.getString("VIN")
                ));
            }
            return results;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object update(Object dto) {
        try {
            Cars updateCar = new Cars();
            int id = updateCar.getId() ;
            Statement stmt = connection.createStatement();
            String sql;
            sql = String.format("UPDATE CARS SET MAKE='%s', MODEL='%s', YEAR=%d, COLOR=%s , VIN=%s WHERE id=%d;",updateCar.getMake(),updateCar.getModel(),updateCar.getYear(),updateCar.getColor(), updateCar.getVin(),id);

            if (stmt.executeUpdate(sql) == 1) {
                return findById(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object create(Object dto) {
        return null;
    }

    public void delete(int id) {

    }
}
