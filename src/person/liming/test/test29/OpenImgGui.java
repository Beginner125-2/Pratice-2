package person.liming.test.test29;

import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;

public class OpenImgGui extends JFrame {
	
	PicShowPanel showImg = new PicShowPanel();
	
	JFileChooser fileChooser = new JFileChooser(".");
	ImgFilter imgFilter = new ImgFilter(); 
	
	JButton btn = new JButton("ѡ��ͼƬ");
	
	public OpenImgGui() {
		//��ʼ��������
		this.setSize(600, 600);
		this.setLayout(new BorderLayout());
		this.add(showImg, BorderLayout.CENTER);
		this.add(btn, BorderLayout.NORTH);
		
		//��ʼ��btn�¼�
		btn.addActionListener(new ActionListener() {
			File file;
			@Override
			public void actionPerformed(ActionEvent e) {
				fileChooser.setFileFilter(imgFilter);
				fileChooser.showOpenDialog(null);
				file = fileChooser.getSelectedFile();
				showImg.setImage(file);
			}
		});
	}
	
	//�ı�����ļ�������
	class ImgFilter extends FileFilter{
		
		@Override
		public String getDescription() {
			
			return "*png,*jpg";
		}
		
		@Override
		public boolean accept(File f) {
			String name = f.getName();
			return f.isDirectory() || name.toLowerCase().endsWith(".png") || name.toLowerCase().endsWith(".jpg");
		}
	}
}
