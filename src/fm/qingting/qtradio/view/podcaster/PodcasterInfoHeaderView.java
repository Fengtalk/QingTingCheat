package fm.qingting.qtradio.view.podcaster;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.viewpagerindicator.CirclePageIndicator;
import fm.qingting.framework.view.IView;
import fm.qingting.framework.view.ViewGroupViewImpl;
import fm.qingting.framework.view.ViewLayout;
import fm.qingting.qtradio.room.UserInfo;

public class PodcasterInfoHeaderView extends ViewGroupViewImpl
{
  private final ViewLayout followLayout = this.standardLayout.createChildLT(720, 60, 0, 360, ViewLayout.SCALE_FLAG_SLTCW);
  private final ViewLayout indicatorLayout = this.standardLayout.createChildLT(720, 104, 0, 50, ViewLayout.SCALE_FLAG_SLTCW);
  private PodcasterInfoPageAdapter mAdapter;
  private PodcasterInfoFollowBtn mFollowBtn;
  private int mHash;
  private CirclePageIndicator mIndicator;
  private UserInfo mPodcasterInfo;
  private ViewPager mViewPager;
  private final ViewLayout standardLayout = ViewLayout.createViewLayoutWithBoundsLT(720, 452, 720, 452, 0, 0, ViewLayout.FILL);
  private final ViewLayout viewpagerLayout = this.standardLayout.createChildLT(720, 256, 0, 104, ViewLayout.SCALE_FLAG_SLTCW);

  public PodcasterInfoHeaderView(Context paramContext, int paramInt)
  {
    super(paramContext);
    setBackgroundResource(2130837889);
    this.mHash = paramInt;
    this.mIndicator = new CirclePageIndicator(paramContext);
    this.mIndicator.setSnap(true);
    this.mIndicator.setStrokeWidth(0.0F);
    this.mIndicator.setFillColor(Color.parseColor("#B2FFFFFF"));
    this.mIndicator.setPageColor(Color.parseColor("#33FFFFFF"));
    this.mViewPager = new ViewPager(paramContext);
    this.mAdapter = new PodcasterInfoPageAdapter();
    this.mViewPager.setAdapter(this.mAdapter);
    this.mIndicator.setViewPager(this.mViewPager);
    this.mFollowBtn = new PodcasterInfoFollowBtn(paramContext);
    addView(this.mIndicator);
    addView(this.mViewPager);
    addView(this.mFollowBtn);
  }

  private void setElementVisible(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mIndicator.setVisibility(0);
      this.mViewPager.setVisibility(0);
      this.mFollowBtn.setVisibility(0);
      return;
    }
    this.mIndicator.setVisibility(4);
    this.mViewPager.setVisibility(4);
    this.mFollowBtn.setVisibility(4);
  }

  public void close(boolean paramBoolean)
  {
    this.mFollowBtn.close(paramBoolean);
    super.close(paramBoolean);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mIndicator.layout(this.indicatorLayout.getLeft(), this.indicatorLayout.getTop(), this.indicatorLayout.getRight(), this.indicatorLayout.getBottom());
    this.mViewPager.layout(this.viewpagerLayout.getLeft(), this.viewpagerLayout.getTop(), this.viewpagerLayout.getRight(), this.viewpagerLayout.getBottom());
    this.mFollowBtn.layout(this.followLayout.getLeft(), this.followLayout.getTop(), this.followLayout.getRight(), this.followLayout.getBottom());
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    this.standardLayout.scaleToBounds(i, j);
    this.indicatorLayout.scaleToBounds(this.standardLayout);
    this.viewpagerLayout.scaleToBounds(this.standardLayout);
    this.followLayout.scaleToBounds(this.standardLayout);
    this.indicatorLayout.measureView(this.mIndicator);
    this.viewpagerLayout.measureView(this.mViewPager);
    this.followLayout.measureView(this.mFollowBtn);
    setMeasuredDimension(i, j);
  }

  public void update(String paramString, Object paramObject)
  {
    if (paramString.equalsIgnoreCase("setData"))
    {
      this.mPodcasterInfo = ((UserInfo)paramObject);
      this.mFollowBtn.update(paramString, paramObject);
      this.mAdapter.notifyDataSetChanged();
    }
    while (!paramString.equalsIgnoreCase("setvisible"))
      return;
    setElementVisible(((Boolean)paramObject).booleanValue());
  }

  public class PodcasterInfoPageAdapter extends PagerAdapter
  {
    public PodcasterInfoPageAdapter()
    {
    }

    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      ((ViewPager)paramViewGroup).removeView((View)paramObject);
    }

    public int getCount()
    {
      return 2;
    }

    public int getItemPosition(Object paramObject)
    {
      return -2;
    }

    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      Object localObject;
      if (paramInt == 0)
      {
        localObject = new PodcasterInfoPage1(PodcasterInfoHeaderView.this.getContext(), PodcasterInfoHeaderView.this.mHash);
        ((IView)localObject).update("setData", PodcasterInfoHeaderView.this.mPodcasterInfo);
      }
      while (true)
      {
        ((ViewPager)paramViewGroup).addView(((IView)localObject).getView());
        return ((IView)localObject).getView();
        localObject = new PodcasterInfoPage2(PodcasterInfoHeaderView.this.getContext());
        ((IView)localObject).update("setData", PodcasterInfoHeaderView.this.mPodcasterInfo);
      }
    }

    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
  }
}

/* Location:           /Users/zhangxun-xy/Downloads/qingting2/classes_dex2jar.jar
 * Qualified Name:     fm.qingting.qtradio.view.podcaster.PodcasterInfoHeaderView
 * JD-Core Version:    0.6.2
 */