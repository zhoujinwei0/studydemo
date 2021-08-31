package com.swagger.demo.response;


public class RespGenerator {
	/**
	 * 接口调用成功时出参
	 * 
	 * @param data
	 *            接口返回数据
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static BaseResponse returnOK(Object data) {
		return new BaseResponse("200", "接口调用成功!", data);
	}

	/**
	 * 调用失败
	 * 
	 * @param code
	 *            错误码
	 * @param message
	 *            错误信息
	 * @return
	 */
	public static BaseResponse<Object> returnError(String code, String message) {
		return new BaseResponse<Object>(code, message, null);
	}

	/**
	 * 调用失败
	 * 
	 * @param message
	 *            错误信息
	 * @return
	 */
	public static BaseResponse<Object> returnError(String message) {
		return new BaseResponse<Object>("-1", message, null);
	}

}
