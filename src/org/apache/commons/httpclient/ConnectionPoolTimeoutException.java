package org.apache.commons.httpclient;

public class ConnectionPoolTimeoutException extends ConnectTimeoutException
{
  public ConnectionPoolTimeoutException()
  {
  }

  public ConnectionPoolTimeoutException(String paramString)
  {
    super(paramString);
  }

  public ConnectionPoolTimeoutException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
}

/* Location:           /Users/zhangxun-xy/Downloads/qingting2/classes_dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.ConnectionPoolTimeoutException
 * JD-Core Version:    0.6.2
 */