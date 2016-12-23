package br.com.master.escalas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.master.escalas.model.TrabalhoFolga;

public class TrabalhoFolgaDAO {
	
	private static final String C_INSERT = "insert into DIAS_FOL (COD_FUN, DIA_FOL) values (?, ?)";
	private static final String R_SELECT = "select COD_FUN DIA_FOL from DIAS_FOL where COD_FUN = ?";
	private static final String U_UPDATE = "update DIAS_FOL set COD_FUN = ?, DIA_FOL = ? where COD_FUN = ?";
	private static final String D_REMOVE = "delete from DIAS_FOL where COD_FUN = ?";
	private static final String FIND_ALL = "select * from DIAS_FOL where MONTH(DIA_FOL) = ? and COD_FUN = ?";
		
	private Connection connection;
	
	public TrabalhoFolgaDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void insert(TrabalhoFolga trabalhoFolga) {
		try (PreparedStatement pstm = this.connection.prepareStatement(C_INSERT)) {
			pstm.setLong(1, trabalhoFolga.getCodigo());
			pstm.setDate(2, trabalhoFolga.getDia());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public TrabalhoFolga select(Long id) {
		TrabalhoFolga trabalhoFolga = new TrabalhoFolga();
		trabalhoFolga.setCodigo(id);		
		try (PreparedStatement pstm = this.connection.prepareStatement(R_SELECT)) {
			pstm.setLong(1, trabalhoFolga.getCodigo());
			try (ResultSet rs = pstm.executeQuery()) {
				if (rs.next()) {
					trabalhoFolga.setCodigo(rs.getLong("COD_FUN"));
					trabalhoFolga.setDia(rs.getDate("DIA_FOL"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return trabalhoFolga;
	}
	
	public void update(TrabalhoFolga trabalhoFolga) {
		try (PreparedStatement pstm = this.connection.prepareStatement(U_UPDATE)) {
			pstm.setLong(1, trabalhoFolga.getCodigo());
			pstm.setDate(2, trabalhoFolga.getDia());
			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove(TrabalhoFolga trabalhoFolga) {
		try (PreparedStatement pstm = this.connection.prepareStatement(D_REMOVE)) {
			pstm.setLong(1, trabalhoFolga.getCodigo());
			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<TrabalhoFolga> getHorarios() {
		try (PreparedStatement pstm = this.connection.prepareStatement(FIND_ALL); ResultSet rs = pstm.executeQuery()) {
			List<TrabalhoFolga> trabalhoFolgas = new ArrayList<TrabalhoFolga>();
			while(rs.next()){
				TrabalhoFolga trabalhoFolga = new TrabalhoFolga();
				trabalhoFolga.setCodigo(rs.getLong("COD_FUN"));
				trabalhoFolga.setDia(rs.getDate("DIA_FOL"));
				trabalhoFolgas.add(trabalhoFolga);
			}
			return trabalhoFolgas;			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
