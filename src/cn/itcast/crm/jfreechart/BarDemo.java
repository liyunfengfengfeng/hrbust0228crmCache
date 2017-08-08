package cn.itcast.crm.jfreechart;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis3D;
import org.jfree.chart.axis.NumberAxis3D;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.util.UnitType;

public class BarDemo {
	public static void main(String[]args){
		//数据集的接口
		CategoryDataset dataset = getDataset();
		/**
		 * 创建一个3d的柱状图
		 * 返回顶级JFreeChart图表
		 */
		JFreeChart chart = ChartFactory.createBarChart3D("某班学生成绩反馈报表",//主标题
														"学生成绩", //等级轴  x轴
														"人数",    //值轴      y轴
														dataset,  //图表需要的数据集
														PlotOrientation.VERTICAL, //图表的方向   水平HORIZONTAL   垂直VERTICAL
														true,                   //是否显示图例即子标题
														true,				//是否显示工具提示
														true);				//是否产生URL链接
		
		
		//获取图表区域对象
		CategoryPlot categoryPlot =  (CategoryPlot) chart.getPlot();
		
		//获取x轴
		CategoryAxis3D categoryAxis3D = (CategoryAxis3D) categoryPlot.getDomainAxis();
		
		//获取y轴
		NumberAxis3D numberAxis3D = (NumberAxis3D) categoryPlot.getRangeAxis();
		
		//获取绘图区域对象  xxxRender
		BarRenderer3D barRenderer3D = (BarRenderer3D) categoryPlot.getRenderer();
		
		
		//处理主标题乱码
		chart.getTitle().setFont(new Font("宋体", Font.BOLD, 18));
		//处理子标题乱码   即 图例乱码
		chart.getLegend().setItemFont(new Font("宋体", Font.BOLD, 18));
		
		
		//处理x轴乱码
			//处理x轴上乱码
		categoryAxis3D.setTickLabelFont(new Font("宋体", Font.BOLD, 15));
			//处理x轴上字体大小
		categoryAxis3D.setLabelFont(new Font("宋体", Font.BOLD, 15));
		//处理y轴乱码
			//处理y轴上乱码
		numberAxis3D.setTickLabelFont(new Font("宋体", Font.BOLD, 15));
			//处理y轴上字体大小
		numberAxis3D.setLabelFont(new Font("宋体", Font.BOLD, 15));
		
		//处理y轴上的刻度
			//设置y轴不是使用自动刻度
		numberAxis3D.setAutoTickUnitSelection(false);
			//设置刻度
		NumberTickUnit numberTickUnit = new NumberTickUnit(1);
		numberAxis3D.setTickUnit(numberTickUnit);
		//处理图形的宽度
		barRenderer3D.setMaximumBarWidth(0.08);
		//处理柱体上的数字
		barRenderer3D.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		//设置柱体上的数字可见
		barRenderer3D.setBaseItemLabelsVisible(true);
		
		//设置柱体上的数字大小
		barRenderer3D.setBaseItemLabelFont(new Font("宋体", Font.BOLD,15));
		//将图标放置在窗体中
		ChartFrame frame = new ChartFrame("信息反馈", chart);
		//设置窗体可见
		frame.setVisible(true);
		//自动调整大小
		frame.pack();
	}

	public static CategoryDataset getDataset() {
		//一个默认的数据集接口
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		//             数据      图例(子标题)  x轴                
		dataset.setValue(15, "学生成绩", "90~100");
		dataset.setValue(12, "学生成绩", "70~90");
		dataset.setValue(6, "学生成绩", "60~70");
		dataset.setValue(3, "学生成绩", "0~60");
		return dataset;
	}
}
