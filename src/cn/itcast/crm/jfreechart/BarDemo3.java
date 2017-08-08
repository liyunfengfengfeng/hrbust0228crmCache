package cn.itcast.crm.jfreechart;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis3D;
import org.jfree.chart.axis.NumberAxis3D;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarDemo3 {
	public static void main(String[]args){
		CategoryDataset categoryDataset = getDataSet();
		//1：创建一个3d的柱状图
		JFreeChart chart = ChartFactory.createBarChart3D("客户分类统计报表(客户等级)",//主标题
				                                         "客户等级",//x轴 
				                                         "数量",//y轴 
				                                         categoryDataset,//数据集 
				                                         PlotOrientation.VERTICAL,//图标的方向  Horizontal水平   vertical垂直 
				                                         true,//设置图例是否可见 
				                                         true,//是否有工具提示 
				                                         true);//是否产生url链接
		//3:获取图表区域对象
		CategoryPlot categoryPlot = (CategoryPlot) chart.getPlot();
		//4: 获取x轴
		CategoryAxis3D categoryAxis3D = (CategoryAxis3D)categoryPlot.getDomainAxis();
		//5:获取y轴
		NumberAxis3D numberAxis3D = (NumberAxis3D) categoryPlot.getRangeAxis();
		//6: 获取绘图区域对象  xxxRender
		BarRenderer3D barRenderer3D = (BarRenderer3D)categoryPlot.getRenderer();
		//7:处理主标题乱码
		chart.getTitle().setFont(new Font("宋体", Font.BOLD, 18));
	    //8: //处理子标题乱码   即 图例乱码
		chart.getLegend().setItemFont(new Font("宋体", Font.BOLD, 15));
		//9: //处理x轴乱码
		
		//10://处理x轴上乱码
		//处理x轴上的乱码
		categoryAxis3D.setTickLabelFont(new Font("宋体", Font.BOLD, 15));
		//11://处理x轴下的乱码
		categoryAxis3D.setLabelFont(new Font("宋体", Font.BOLD, 15));
		//12://处理y轴上乱码
		numberAxis3D.setTickLabelFont(new Font("宋体", Font.BOLD, 15));
		//13://处理y轴上乱码
		//14://处理y轴下字体大小
		numberAxis3D.setLabelFont(new Font("宋体", Font.BOLD, 15));
		//15://处理y轴上的刻度
		
		//16://设置y轴不是使用自动刻度
		numberAxis3D.setAutoTickUnitSelection(false);
		//17://设置刻度
		NumberTickUnit numberTickUnit = new NumberTickUnit(1);
		numberAxis3D.setTickUnit(numberTickUnit);
		//18://处理图形的宽度
		barRenderer3D.setMaximumBarWidth(0.08);
		//19://处理柱体上的数字
		barRenderer3D.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		//20://设置柱体上的数字可见
		barRenderer3D.setBaseItemLabelsVisible(true);
		//21://设置柱体上的数字大小
		barRenderer3D.setBaseItemLabelFont(new Font("宋体", Font.BOLD, 15));
		//22://将图标放置在窗体中
		ChartFrame frame = new ChartFrame("xxx", chart);
		//23://设置窗体可见
		frame.setVisible(true);
		//24://自动调整大小
		frame.pack();
	}

	private static org.jfree.data.category.CategoryDataset getDataSet() {
		//使用默认的数据集
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		//为数据集添加数据           y     图例              x
		dataset.addValue(3, "客户等级", "机会客户");
		dataset.addValue(1, "客户等级", "签约客户");
		dataset.addValue(2, "客户等级", "重要客户");
		dataset.addValue(3, "客户等级", "潜在客户");
		return dataset;
	}
}
