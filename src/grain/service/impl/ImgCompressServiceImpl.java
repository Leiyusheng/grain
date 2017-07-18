package grain.service.impl;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import grain.service.ImgCompressService;

@Service
public class ImgCompressServiceImpl implements ImgCompressService {

	private Image img;
    private String url;
    private int width;  
    private int height;  
    private static int head_size=200;
    private static int task_size=150;
    private static int result_size=400;
	@Override
	public void imgCompress(String fileName,String targetUrl,int method)throws IOException {
		File file = new File(fileName);// �����ļ�  
        url = targetUrl;			   // �õ�ͼƬ��
        img = ImageIO.read(file);      // ����Image����  
        width = img.getWidth(null);    // �õ�Դͼ��  
        height = img.getHeight(null);  // �õ�Դͼ��  
        int size=0;
        switch (method) {
		case 1:
			size =head_size;
			break;
		case 2:
			size =task_size;
			break;
		case 3:
			size =result_size;
		default:
			break;
		}
        if(width>size||height>size){
        	resizeFix(size, size); 
        }
        else{
        	resizeFix(width, height);
        }
	}
	  
    /** 
     * ���տ�Ȼ��Ǹ߶Ƚ���ѹ�� 
     * @param w int ����� 
     * @param h int ���߶� 
     */  
    private void resizeFix(int w, int h) throws IOException {  
        if (width * h > w * height) {  
            resizeByWidth(w);  
        } else {  
            resizeByHeight(h);
        }  
    }  
    /** 
     * �Կ��Ϊ��׼���ȱ�������ͼƬ 
     * @param w int �¿�� 
     */  
    private void resizeByWidth(int w) throws IOException {  
        int h = (int) (height * w / width);  
        resize(w, h);  
    }  
    /** 
     * �Ը߶�Ϊ��׼���ȱ�������ͼƬ 
     * @param h int �¸߶� 
     */  
    private void resizeByHeight(int h) throws IOException {  
        int w = (int) (width * h / height);  
        resize(w, h);  
    }  
    /** 
     * ǿ��ѹ��/�Ŵ�ͼƬ���̶��Ĵ�С 
     * @param w int �¿�� 
     * @param h int �¸߶� 
     */  
    private void resize(int w, int h) throws IOException {  
        // SCALE_SMOOTH �������㷨 ��������ͼƬ��ƽ���ȵ� ���ȼ����ٶȸ� ���ɵ�ͼƬ�����ȽϺ� ���ٶ���  
        BufferedImage image = new BufferedImage(w, h,BufferedImage.TYPE_INT_RGB );   
        image.getGraphics().drawImage(img, 0, 0, w, h, null); // ������С���ͼ  
        File destFile = new File(url);  
        FileOutputStream out = new FileOutputStream(destFile); // ������ļ���  
        // ��������ʵ��bmp��png��gifתjpg  
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);  
        encoder.encode(image); // JPEG����  
        out.close();  
    } 
}
