package com.taobao.newxp.net;

import android.content.Context;
import android.net.http.AndroidHttpClient;
import com.taobao.munion.base.Log;
import com.taobao.munion.base.volley.a.a;
import com.taobao.munion.base.volley.a.d;
import com.taobao.munion.base.volley.l;
import com.taobao.munion.base.volley.m;
import java.io.File;
import org.apache.http.client.CookieStore;

public class j
  implements c
{
  private m b;
  private CookieStore c;
  private String d = "";
  private boolean e = false;

  public j(String paramString)
  {
    this.d = paramString;
  }

  public <T> l<T> a(l<T> paraml)
  {
    if (this.b != null)
    {
      if (!e.z())
      {
        e locale = e.a();
        if (locale == null)
          break label53;
        locale.a = true;
        this.b.a(locale);
        Log.i("add cna-requset for udpdate cookie.", new Object[0]);
      }
      while (true)
      {
        return this.b.a(paraml);
        label53: Log.i("exist activity cna-request in queue.", new Object[0]);
      }
    }
    throw new RuntimeException("MunionVolley is not initized..");
  }

  public c a(Context paramContext)
  {
    File localFile = new File(paramContext.getCacheDir(), "taobao_munion");
    f localf = new f(AndroidHttpClient.newInstance(this.d));
    if (this.c != null)
      localf.a(this.c);
    a locala = new a(localf);
    d locald = new d(localFile);
    if (this.e);
    for (int i = 3; ; i = 1)
    {
      this.b = new m(locald, locala, i);
      this.b.a();
      return this;
    }
  }

  public j a(CookieStore paramCookieStore)
  {
    this.c = paramCookieStore;
    return this;
  }

  public j a(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }

  public CookieStore a()
  {
    return this.c;
  }
}

/* Location:           /Users/zhangxun-xy/Downloads/qingting2/classes_dex2jar.jar
 * Qualified Name:     com.taobao.newxp.net.j
 * JD-Core Version:    0.6.2
 */