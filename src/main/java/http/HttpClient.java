package http;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClient {
    public static void main(String[] args) throws Exception {
        //创建一个客户端
        CloseableHttpClient client = HttpClients.createDefault();

        //创建一个get方法
        HttpGet get = new HttpGet("http://www.baidu.com");

        //执行请求
        HttpResponse res = client.execute(get);

        //获取协议版本・・・「HTTP/1.1」
        System.out.println(res.getProtocolVersion());
        //获取返回状态码・・・「200」
        System.out.println(res.getStatusLine().getStatusCode());
        //获取原因短语・・・「OK」
        System.out.println(res.getStatusLine().getReasonPhrase());
        //获取完整的StatusLine・・・「HTTP/1.1 200 OK」
        System.out.println(res.getStatusLine().toString());

        //获取返回头部信息
        Header[] headers = res.getAllHeaders();
        for (Header header : headers) {
            System.out.println(header.getName() + ": " + header.getValue());
        }

        //获取返回内容
        if (res.getEntity() != null) {
            System.out.println(EntityUtils.toString(res.getEntity()));
        }

        //关闭流
        EntityUtils.consume(res.getEntity());

        //关闭连接
        client.close();
    }
}