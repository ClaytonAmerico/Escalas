package br.com.master.escalas.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.master.escalas.model.EscalaFeriado;

public class EscalaFeriadoDAO {
	
	private static final String C_INSERT = "insert into ESC_FERIADO (FER_DIA, COD_FUN, ID_HORA, ID_SETOR) values (?, ?, ?, ?)";
	private static final String R_SELECT = "select * from ESC_FERIADO where FER_DIA = ?";
	private static final String U_UPDATE = "update ESC_FERIADO set FER_DIA = ?, COD_FUN = ?, ID_HORA = ?, ID_SETOR = ? where ID = ?";
	private static final String D_REMOVE = "delete from ESC_FERIADO where FER_DIA = ?";
	
	private Connection connection;
	
	public EscalaFeriadoDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void insert(EscalaFeriado escalaFeriado) {
		try (PreparedStatement pstm = this.connection.prepareStatement(C_INSERT)) {
			pstm.setDate(1, escalaFeriado.getFeriado());
			pstm.setLong(2, escalaFeriado.getIdF());
			pstm.setLong(3, escalaFeriado.getIdH());
			pstm.setLong(4, escalaFeriado.getIdS());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<EscalaFeriado> getHorarios(Date dia) {
		try (PreparedStatement pstm = this.connection.prepareStatement(R_SELECT); ResultSet rs = pstm.executeQuery()) {
			pstm.setDate(1, dia);
			List<EscalaFeriado> escalaFeriados = new ArrayList<EscalaFeriado>();
			while(rs.next()){
				EscalaFeriado escalaFeriado = new EscalaFeriado();
				escalaFeriado.setFeriado(rs.getDate("FER_DIA"));
				escalaFeriado.setIdF(rs.getLong("COD_FUN"));
				escalaFeriado.setIdH(rs.getLong("ID_HORA"));
				escalaFeriado.setIdS(rs.getLong("ID_SETOR"));
				escalaFeriados.add(escalaFeriado);
			}
			return escalaFeriados;			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(EscalaFeriado escalaFeriado) {
		try (PreparedStatement pstm = this.connection.prepareStatement(U_UPDATE)) {
			pstm.setDate(1, escalaFeriado.getFeriado());
			pstm.setLong(2, escalaFeriado.getIdF());
			pstm.setLong(3, escalaFeriado.getIdH());
			pstm.setLong(4, escalaFeriado.getIdS());
			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove(EscalaFeriado escalaFeriado) {
		try (PreparedStatement pstm = this.connection.prepareStatement(D_REMOVE)) {
			pstm.setDate(2, escalaFeriado.getFeriado());
			pstm.execute();			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
