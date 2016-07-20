/**
 * Copyright 2015-2016 Knowm Inc. (http://knowm.org) and contributors.
 * Copyright 2011-2015 Xeiam LLC (http://xeiam.com) and contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.knowm.xchart.standalone;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

/**
 * Creates a simple real-time Chart using QuickChart
 */
public class SimpleRealTime {

  public static void main(String[] args) throws Exception {

    final double[] yData = new double[] { 2.0, 1.0, 0.0 };

    // Create Chart
    XYChart chart = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", null, yData);

    // Show it
    final SwingWrapper<XYChart> sw = new SwingWrapper(chart);

    sw.displayChart();

    for (int i = 0; i < 1000; i++) {

      Thread.sleep(100);
      yData[0]++;
      yData[1]++;
      yData[2]++;

      javax.swing.SwingUtilities.invokeLater(new Runnable() {

        @Override
        public void run() {

          sw.getXChartPanel().updateXYSeries("y(x)", null, yData, null);
        }
      });
    }

  }
}
