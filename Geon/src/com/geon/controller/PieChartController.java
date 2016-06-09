package com.geon.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.jdbc.JDBCPieDataset;

import com.geon.config.DbUtil;

public class PieChartController extends HttpServlet {

	/**
	 * 
	 */
	private Connection connection;
	private static final long serialVersionUID = 1L;

	public PieChartController() throws ClassNotFoundException, IOException, SQLException {
		connection = DbUtil.getConnection();
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		JDBCPieDataset dataSet = new JDBCPieDataset(connection);
	
		try
		{
		dataSet.executeQuery("SELECT status, count(*) as noofRecs FROM `complaintregistration` GROUP BY status");
		JFreeChart chart = ChartFactory.createPieChart("Complaints", dataSet, true, true, false);
		if(chart!=null)
		{
			chart.setBorderVisible(true);
			int width = 600;
			int height = 400;
			response.setContentType("image/jpeg");
            OutputStream out = response.getOutputStream();
            ChartUtilities.writeChartAsJPEG(out, chart, width, height);
		}
		}catch (SQLException e) {
            System.err.println(e.getMessage());
    }
		
	}
}
