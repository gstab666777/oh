package org.isf.stat.gui.report;

import net.sf.jasperreports.view.JasperViewer;
import org.isf.generaldata.GeneralData;
import org.isf.generaldata.MessageBundle;
import org.isf.stat.dto.JasperReportResultDto;
import org.isf.stat.manager.JasperReportsManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;

public class DiseasesList {
    private final Logger logger = LoggerFactory.getLogger(DiseasesList.class);
    public DiseasesList() {
        try{
            JasperReportsManager jasperReportsManager = new JasperReportsManager();
            JasperReportResultDto jasperReportResultDto = jasperReportsManager.getDiseasesListPdf();
            //mostra a video
            if (GeneralData.INTERNALVIEWER)
                JasperViewer.viewReport(jasperReportResultDto.getJasperPrint(),false);
            else {
                Runtime rt = Runtime.getRuntime();
                rt.exec(GeneralData.VIEWER + " " + jasperReportResultDto.getFilename());
            }
        } catch (Exception e) {
            logger.error("", e);
            JOptionPane.showMessageDialog(null, MessageBundle.getMessage("angal.stat.reporterror"), MessageBundle.getMessage("angal.hospital"), JOptionPane.ERROR_MESSAGE);
        }
    }
}
