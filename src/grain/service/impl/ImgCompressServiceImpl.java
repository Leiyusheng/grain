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
        File file = new File(fileName);// 读入文件  
        url = targetUrl;               // 得到图片名
        img = ImageIO.read(file);      // 构造Image对象  
        width = img.getWidth(null);    // 得到源图宽  
        height = img.getHeight(null);  // 得到源图长  
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
     * 按照宽度还是高度进行压缩 
     * @param w int 最大宽度 
     * @param h int 最大高度 
     */  
    private void resizeFix(int w, int h) throws IOException {  
        if (width * h > w * height) {  
            resizeByWidth(w);  
        } else {  
            resizeByHeight(h);
        }  
    }  
    /** 
     * 以宽度为基准，等比例放缩图片 
     * @param w int 新宽度 
     */  
    private void resizeByWidth(int w) throws IOException {  
        int h = (int) (height * w / width);  
        resize(w, h);  
    }  
    /** 
     * 以高度为基准，等比例缩放图片 
     * @param h int 新高度 
     */  
    private void resizeByHeight(int h) throws IOException {  
        int w = (int) (width * h / height);  
        resize(w, h);  
    }  
    /** 
     * 强制压缩/放大图片到固定的大小 
     * @param w int 新宽度 
     * @param h int 新高度 
     */  
    private void resize(int w, int h) throws IOException {  
        // SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢  
        BufferedImage image = new BufferedImage(w, h,BufferedImage.TYPE_INT_RGB );   
        image.getGraphics().drawImage(img, 0, 0, w, h, null); // 绘制缩小后的图  
        File destFile = new File(url);  
        FileOutputStream out = new FileOutputStream(destFile); // 输出到文件流  
        // 可以正常实现bmp、png、gif转jpg  
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);  
        encoder.encode(image); // JPEG编码  
        out.close();  
    } 
}
