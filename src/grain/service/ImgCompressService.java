package grain.service;

public interface ImgCompressService {
	/**
	 * 进行图片压缩
	 * @param fileName 原图片路径
	 * @param targetUrl 目标图片路径
	 * @param method 图片压缩方式： 1头像，2任务图标，3发表状态图片
	 * @throws Exception
	 */
	public void imgCompress(String fileName,String targetUrl,int method)throws Exception;
}
