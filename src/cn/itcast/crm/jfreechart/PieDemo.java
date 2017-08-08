package cn.itcast.crm.jfreechart;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Shape;
import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryAxis3D;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberAxis3D;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.UnitType;

public class PieDemo {
	public static void main(String[]args){
		//数据集的接口
		PieDataset dataset = getDataset();
		/**
		 * 创建一个饼状图
		 * 返回顶级JFreeChart图表
		 */
		JFreeChart chart = ChartFactory.createPieChart3D("显示各班平均成绩报表", //主标题
														dataset,  //图表需要的数据集
														true,     //是否显示图例即子标题
														true,	  //是否显示工具提示
														true);	  //是否产生URL链接
														
														
		
		
		//获取图表区域对象
		PiePlot3D piePlot3D =  (PiePlot3D) chart.getPlot();
		

		
		//处理主标题乱码
		chart.getTitle().setFont(new Font("宋体", Font.BOLD, 18));
		//处理子标题乱码   即 图例乱码
		chart.getLegend().setItemFont(new Font("宋体", Font.BOLD, 18));
		//处理饼图标题字体乱码
		piePlot3D.setLabelFont(new Font("宋体", Font.BOLD, 15));
		//处理饼图显示的信息
		String labelFormat = "{0}:{1}({2})";
		piePlot3D.setLabelGenerator(new StandardPieSectionLabelGenerator(labelFormat));
		
		
		
		//生成图片
//		File file= new File("D:\\houtai\\8-CRM项目\\09_CRM项目\\0919\\a.jpeg");
//		try {
//			ChartUtilities.saveChartAsJPEG(file, chart, 600, 400);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
		
		
		ChartFrame frame = new ChartFrame("平均成绩", chart);
		frame.setVisible(true);
		//自动调整大小
		frame.pack();
	}

	public static PieDataset getDataset() {
		//一个默认的数据集接口
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("一班", 25);
		dataset.setValue("二班", 35);
		dataset.setValue("三班", 15);
		dataset.setValue("四班", 25);
		
		
//		//             数据      图例(子标题)  x轴                
//		dataset.setValue(3, "客户等级", "机会客户");
//		dataset.setValue(1, "客户等级", "签约客户");
//		dataset.setValue(4, "客户等级", "重要客户");
//		dataset.setValue(3, "客户等级", "潜在客户");
		return dataset;
	}
}
