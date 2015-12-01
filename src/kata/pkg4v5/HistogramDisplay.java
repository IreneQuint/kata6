package kata.pkg4v5;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay <T> extends ApplicationFrame {

    private final Histogram<T> histogram;

    public HistogramDisplay(Histogram<T> histogram) {
        super("HISTOGRAM");
        this.histogram = histogram;
        setContentPane(createPanel());
        pack();
    }

    private JPanel createPanel() {
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        chartPanel.setPreferredSize(new Dimension(500, 500));
        return chartPanel;
    }

    private JFreeChart createChart(DefaultCategoryDataset dataSet) {
        JFreeChart chart = ChartFactory.createBarChart("Histogram", "Domains", "Nº emails", dataSet, PlotOrientation.VERTICAL, true, rootPaneCheckingEnabled, rootPaneCheckingEnabled);
        return chart;
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for (Object key : histogram.keySet()) {
            dataSet.addValue(histogram.get(key), "", (Comparable) key);
        }

        return dataSet;
    }

    public void execute() {
        setVisible(true);
    }

}
