package clases;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class BDController {
    private Connection miConexion;

    public BDController() {
        super();
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //Configuro la conexion con la BBDD
            this.miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/PARTIDO_HUMANO", "root", "");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Error en constructor BDController " + e.getMessage());
        }
    }

    public ArrayList<Asistentes> dameAsistentes() {
        ArrayList<Asistentes> asistentes = new ArrayList<Asistentes>();
        try {
            Statement miStatement = this.miConexion.createStatement();
            ResultSet rs = miStatement.executeQuery("SELECT * FROM asistentes order by cod_voluntario asc");
            while (rs.next()) {
                asistentes.add(new Asistentes(rs.getInt(1), rs.getInt(2)));
            }
            miStatement.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("Error en dameEquipos de BDController " + e.getMessage());
        }
        return asistentes;
    }

    public ArrayList<Campanna> dameCampannas() {
        ArrayList<Campanna> campannas = new ArrayList<Campanna>();
        try {
            Statement miStatement = this.miConexion.createStatement();
            ResultSet rs = miStatement.executeQuery("SELECT * FROM campanna order by cod_campanna asc");
            while (rs.next()) {
                campannas.add(new Campanna(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
            miStatement.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("Error en dameCampannas de BDController " + e.getMessage());
        }
        return campannas;
    }

    public ArrayList<Candidato> dameCandidatos() {
        ArrayList<Candidato> candidatos = new ArrayList<Candidato>();
        try {
            Statement miStatement = this.miConexion.createStatement();
            ResultSet rs = miStatement.executeQuery("SELECT * FROM campanna order by cod_campanna asc");
            while (rs.next()) {
                candidatos.add(new Candidato(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
            }
            miStatement.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("Error en dameCandidatos de BDController " + e.getMessage());
        }
        return candidatos;
    }

    public ArrayList<Candidatura> dameCandidatura() {
        ArrayList<Candidatura> candidaturas = new ArrayList<Candidatura>();
        try {
            Statement miStatement = this.miConexion.createStatement();
            ResultSet rs = miStatement.executeQuery("SELECT * FROM candidaturas order by cod_candidato asc");
            while (rs.next()) {
                candidaturas.add(new Candidatura(rs.getInt(1), rs.getInt(2), rs.getString(3),rs.getInt(5)));
            }
            miStatement.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("Error en dameCandidatura de BDController " + e.getMessage());
        }
        return candidaturas;
    }

    public ArrayList<Evento> dameEventos() {
        ArrayList<Evento> eventos = new ArrayList<Evento>();
        try {
            Statement miStatement = this.miConexion.createStatement();
            ResultSet rs = miStatement.executeQuery("SELECT * FROM eventos order by cod_evento asc");
            while (rs.next()) {
                eventos.add(new Evento(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getTime(5),rs.getString(6),rs.getInt(7),rs.getString(8)));
            }
            miStatement.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("Error en dameEventos de BDController " + e.getMessage());
        }
        return eventos;
    }

    public ArrayList<Noticia> dameNoticias() {
        ArrayList<Noticia> noticias = new ArrayList<Noticia>();
        try {
            Statement miStatement = this.miConexion.createStatement();
            ResultSet rs = miStatement.executeQuery("SELECT * FROM noticias order by cod_noticia asc");
            while (rs.next()) {
                noticias.add(new Noticia(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
            }
            miStatement.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("Error en dameNoticias de BDController " + e.getMessage());
        }
        return noticias;
    }

    public ArrayList<Programa> dameProgramas() {
        ArrayList<Programa> programas = new ArrayList<Programa>();
        try {
            Statement miStatement = this.miConexion.createStatement();
            ResultSet rs = miStatement.executeQuery("SELECT * FROM programa order by cod_punto asc");
            while (rs.next()) {
                programas.add(new Programa(rs.getInt(1),rs.getString(2),rs.getInt(3)));
            }
            miStatement.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("Error en dameProgramas de BDController " + e.getMessage());
        }
        return programas;
    }

    public ArrayList<Voluntariado> dameVoluntariados() {
        ArrayList<Voluntariado> voluntariados = new ArrayList<Voluntariado>();
        try {
            Statement miStatement = this.miConexion.createStatement();
            ResultSet rs = miStatement.executeQuery("SELECT * FROM voluntariados order by cod_voluntariado asc");
            while (rs.next()) {
                voluntariados.add(new Voluntariado(rs.getInt(1),rs.getInt(3)));
            }
            miStatement.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("Error en dameVoluntariados de BDController " + e.getMessage());
        }
        return voluntariados;
    }

    public ArrayList<Noticia> dame4NoticiasCampanna() {
        ArrayList<Noticia> noticias = new ArrayList<Noticia>();
        try {
            Statement miStatement = this.miConexion.createStatement();
            ResultSet rs = miStatement.executeQuery("select * from noticias where cod_campanna in (select campanna.cod_campanna from campanna where campanna.titulo = 'Europa') limit 4");
            while (rs.next()) {
                noticias.add(new Noticia(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
            }
            miStatement.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("Error en dame4NoticiasCampanna de BDController " + e.getMessage());
        }
        return noticias;
    }

    public ArrayList<Evento> dame5proximosEventos() {
        ArrayList<Evento> eventos = new ArrayList<Evento>();
        try {
            Statement miStatement = this.miConexion.createStatement();
            ResultSet rs = miStatement.executeQuery("SELECT * FROM eventos WHERE DATE(dia)>CURDATE() order by dia limit 5;");
            while (rs.next()) {
                eventos.add(new Evento(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getTime(5),rs.getString(6),rs.getInt(7),rs.getString(8)));
            }
            miStatement.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en dame5proximosEventos de BDController " + e.getMessage());
        }
        return eventos;
    }

    public ArrayList<Programa> dame10primerosPuntosPrograma() {
        ArrayList<Programa> programas = new ArrayList<Programa>();
        try {
            Statement miStatement = this.miConexion.createStatement();
            ResultSet rs = miStatement.executeQuery("select * from programa where cod_campanna in (select cod_campanna from campanna where titulo = 'nacional') limit 10");
            while (rs.next()) {
                programas.add(new Programa(rs.getInt(1),rs.getString(2),rs.getInt(3)));
            }
            miStatement.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en dame10primerosPuntosPrograma de BDController " + e.getMessage());
        }
        return programas;
    }
}