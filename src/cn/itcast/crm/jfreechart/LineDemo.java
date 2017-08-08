package cn.itcast.crm.jfreechart;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Shape;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryAxis3D;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberAxis3D;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.util.UnitType;

public class LineDemo {
	public static void main(String[]args){
		//数据集的接口
		CategoryDataset dataset = getDataset();
		/**
		 * 创建一个线状图
		 * 返回顶级JFreeChart图表
		 */
		JFreeChart chart = ChartFactory.createLineChart("某同学各科成绩反馈报表",//主标题
														"成绩反馈", //等级轴  x轴
														"分数",    //值轴      y轴
														dataset,  //图表需要的数据集
														PlotOrientation.VERTICAL, //图表的方向   水平HORIZONTAL   垂直VERTICAL
														true,                   //是否显示图例即子标题
														true,				//是否显示工具提示
														true);				//是否产生URL链接
		
		
		//获取图表区域对象
		CategoryPlot categoryPlot =  (CategoryPlot) chart.getPlot();
		
		//获取x轴
		CategoryAxis categoryAxis = (CategoryAxis) categoryPlot.getDomainAxis();
		
		//获取y轴
		NumberAxis numberAxis = (NumberAxis) categoryPlot.getRangeAxis();
		
		//获取绘图区域对象  xxxRender
		LineAndShapeRenderer lineAndShapeRenderer = (LineAndShapeRenderer) categoryPlot.getRenderer();
		
		
		//处理主标题乱码
		chart.getTitle().setFont(new Font("宋体", Font.BOLD, 18));
		//处理子标题乱码   即 图例乱码
		chart.getLegend().setItemFont(new Font("宋体", Font.BOLD, 18));
		
		
		//处理x轴乱码
			//处理x轴上乱码
		categoryAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 15));
			//处理x轴上乱码
		categoryAxis.setLabelFont(new Font("宋体", Font.BOLD, 15));
		//处理y轴乱码
			//处理y轴上乱码
		numberAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 15));
			//处理y轴上乱码
		numberAxis.setLabelFont(new Font("宋体", Font.BOLD, 15));
		
		//处理y轴上的刻度
			//设置y轴不是使用自动刻度
		numberAxis.setAutoTickUnitSelection(false);
			//设置刻度
		NumberTickUnit numberTickUnit = new NumberTickUnit(10);
		numberAxis.setTickUnit(numberTickUnit);

		//处理柱体上的数字
		lineAndShapeRenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		//设置柱体上的数字可见
		lineAndShapeRenderer.setBaseItemLabelsVisible(true);
		
		//设置柱体上的数字大小
		lineAndShapeRenderer.setBaseItemLabelFont(new Font("宋体", Font.BOLD,15));
		
		//处理拐角处的点
		//设置拐角点的形状  矩形
		Rectangle rectangle = new Rectangle(8,8);
		lineAndShapeRenderer.setSeriesShape(0, rectangle);
		lineAndShapeRenderer.setSeriesShapesVisible(0, true);
		
		
		
		ChartFrame frame = new ChartFrame("成绩反馈", chart);
		frame.setVisible(true);
		//自动调整大小
		frame.pack();
	}

	public static CategoryDataset getDataset() {
		//一个默认的数据集接口
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		//             数据      图例(子标题)  x轴                
		dataset.setValue(100, "成绩反馈", "struts2");
		dataset.setValue(88, "成绩反馈", "spring");
		dataset.setValue(66, "成绩反馈", "hibernate");
		dataset.setValue(56, "成绩反馈", "mysql");
		return dataset;
	}
}
