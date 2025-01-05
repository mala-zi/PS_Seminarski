/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbb;

import java.sql.SQLException;

/**
 *
 * @author Saki
 */
public class TransactionManager {
    private static TransactionManager instance;

    public static TransactionManager getInstance() throws SQLException {
        if (instance == null) {
            instance = new TransactionManager();
        }
        return instance;
    }

    public void commitTransaction() throws SQLException {
        DatabaseBroker.getInstance().commit();
    }

    public void rollbackTransaction() throws SQLException {
        DatabaseBroker.getInstance().rollback();
    }
}

