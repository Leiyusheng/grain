package grain.service;

public interface ImgCompressService {
	/**
	 * ����ͼƬѹ��
	 * @param fileName ԭͼƬ·��
	 * @param targetUrl Ŀ��ͼƬ·��
	 * @param method ͼƬѹ����ʽ�� 1ͷ��2����ͼ�꣬3����״̬ͼƬ
	 * @throws Exception
	 */
	public void imgCompress(String fileName,String targetUrl,int method)throws Exception;
}
