package org.example;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.sql.Connection;
import java.sql.SQLException;

public class ConexionDBTest {
    private static final String DB = "prueba";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String INVALID_USER = "admin";

    @Rule
    public ExpectedException exception = ExpectedException.none();
    private ConexionDB conexionDB;

    @Test
    public void conexionCorrecta() {
        conexionDB = new ConexionDB(DB, USER, PASSWORD);
        Connection conex = null;
        try {
            conex = conexionDB.getConnection();
        } catch (SQLException e) {
            Assert.fail("La conexion ha fallado");
        }

        MatcherAssert.assertThat(conex, CoreMatchers.notNullValue());
        MatcherAssert.assertThat(conexionDB.getDb(), CoreMatchers.equalTo(DB));
        MatcherAssert.assertThat(conexionDB.getUser(), CoreMatchers.equalTo(USER));
        MatcherAssert.assertThat(conexionDB.getPassword(), CoreMatchers.equalTo(PASSWORD));
        MatcherAssert.assertThat(conexionDB.getUrl(), CoreMatchers.equalTo("jdbc:mysql://localhost/" + conexionDB.getDb() + "?"));
    }

    @Test(expected = SQLException.class)
    public void conexionFallidaAnotaciones() throws SQLException {
        conexionDB = new ConexionDB(DB, INVALID_USER, PASSWORD);
        conexionDB.getConnection();
    }

    @Test
    public void conexionFallida() {
        conexionDB = new ConexionDB(DB, INVALID_USER, PASSWORD);
        Connection conex = null;
        try {
            conex = conexionDB.getConnection();
            Assert.fail("La conexion ha fallado");
        } catch (SQLException e) {
            MatcherAssert.assertThat(e, CoreMatchers.isA(SQLException.class));
            MatcherAssert.assertThat(e.getMessage(), CoreMatchers.startsWith("Access denied"));
            MatcherAssert.assertThat(e.getMessage(), CoreMatchers.containsString("Access denied"));
            MatcherAssert.assertThat(e.getSQLState(), CoreMatchers.is("28000"));
        }

        MatcherAssert.assertThat(conex, CoreMatchers.nullValue());
    }

    @Test
    public void testFallidaRegla() throws SQLException {
        exception.expect(SQLException.class);
        exception.expectMessage("Access denied for user 'admin'@'localhost' (using password: YES)");
        exception.expectMessage("Access denied");
        exception.expectMessage("'admin'@'localhost'");
        exception.expectMessage(CoreMatchers.equalTo("Access denied for user 'admin'@'localhost' (using password: YES)"));
        exception.expectMessage(CoreMatchers.containsString("'admin'@'localhost'"));
        exception.expectMessage(CoreMatchers.startsWith("Access denied"));
        exception.expectMessage(CoreMatchers.endsWith("(using password: YES)"));
        conexionDB = new ConexionDB(DB, INVALID_USER, PASSWORD);
        conexionDB.getConnection();
    }

    @Test
    public void assumeTest() {
        conexionDB = new ConexionDB(DB, INVALID_USER, PASSWORD);
        Connection conex = null;
        try {
            conex = conexionDB.getConnection();
        } catch (SQLException e) {
            Assume.assumeNotNull(conex);
        }
    }
}