package com.example.testgui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatebaseHandler extends Configs {
    Connection dbConnection;
    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public void signUpUser1(User user) throws SQLException, ClassNotFoundException {
        String insertClient = "INSERT INTO " + Const.CLIENT_TABLE + "( " + Const.CLIENTS_NUMBER_PHONE + "," + Const.CLIENTS_NAME +
                "," + Const.CLIENT_TYPE_SERVICE + ")" + "VALUES(?,?,?)";

        PreparedStatement prSt = getDbConnection().prepareStatement(insertClient);

        prSt.setString(1, user.getNumber_phone());
        prSt.setString(2, user.getName());
        prSt.setString(3, user.getType_service());
        prSt.executeUpdate();
    }

    public void signUpUser2(User user) throws SQLException, ClassNotFoundException {
        String insertAdditionalInfo = "INSERT INTO " + Const.ADDITIONAL_INFO_TABLE + "( " +
                Const.ADDITIONAL_INFO_DATE_RECORDING + "," + Const.ADDITIONAL_INFO_BRAND_AUTO + ", "
                + Const.ADDITIONAL_INFO_MODEL + ", " + Const.ADDITIONAL_INFO_DATE_ISSUE
                + ", " + Const.ADDITIONAL_INFO_DESC_PROBLEM + ", " + Const.ADDITIONAL_INFO_RADIUS_WHEEL + ")" +
                "VALUES(?,?,?,?,?,?)";

        PreparedStatement prSt2 = getDbConnection().prepareStatement(insertAdditionalInfo);

        prSt2.setString(1, user.getDate_recording());
        prSt2.setString(2, user.getBrand_auto());
        prSt2.setString(3, user.getModel());
        prSt2.setString(4, user.getDate_issue());
        prSt2.setString(5, user.getDesc_problem());
        prSt2.setString(6, user.getRadius_wheel().toString());

        prSt2.executeUpdate();
    }
}
