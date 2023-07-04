package be.devrise.educommute.claim;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Year;

public class NumberClaimIdGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        int currentYear = Year.now().getValue();
        String query = String.format("select MAX(%s) from %s where year = %s",
                "number",
                "refund_request",currentYear);
        Connection connection = sharedSessionContractImplementor.connection();
       try{
           Statement st = connection.createStatement();
           ResultSet rs = st.executeQuery(query);
           if(rs.next()){
               int id = rs.getInt(1)+1;
               System.out.println("ID of claim : "+ id);
               return id;
           }
       }catch(SQLException e){
           e.printStackTrace();
       }

        return null;
    }
}
