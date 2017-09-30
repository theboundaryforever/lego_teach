package com.haoyu.app.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.haoyu.app.basehelper.BaseArrayRecyclerAdapter;
import com.haoyu.app.entity.MEvaluateEntity;
import com.haoyu.app.entity.MobileUser;
import com.haoyu.app.lego.teach.R;
import com.haoyu.app.imageloader.GlideImgManager;
import com.haoyu.app.utils.TimeUtil;

import com.haoyu.app.view.StarBar;

import java.util.List;

/**
 * Created by acer1 on 2017/2/23.
 * <p>
 * 评价结果更多建议列表详情
 */
public class TeachingStudyEvaluationAdapter extends BaseArrayRecyclerAdapter<MEvaluateEntity> {
    private Context context;

    public TeachingStudyEvaluationAdapter(Context context, List<MEvaluateEntity> mDatas) {
        super(mDatas);
        this.context = context;
    }

    @Override
    public void onBindHoder(RecyclerHolder holder, MEvaluateEntity entity, int position) {
        ImageView iv_img = holder.obtainView(R.id.iv_img);
        TextView tv_name = holder.obtainView(R.id.tv_name);
        StarBar ratingBar1 = holder.obtainView(R.id.ratingBar1);
        TextView tv_content = holder.obtainView(R.id.tv_content);
        TextView tv_time = holder.obtainView(R.id.tv_time);
        StarBar ratingBar = holder.obtainView(R.id.ratingBar1);
        if (entity != null && entity.getCreator() != null) {
            MobileUser mobileUser = entity.getCreator();
            if (mobileUser.getRealName() != null) {
                tv_name.setText(mobileUser.getRealName());
            }

            GlideImgManager.loadCircleImage(context,mobileUser.getAvatar()
                    , R.drawable.user_default, R.drawable.user_default, iv_img);
        } else {
            iv_img.setImageResource(R.drawable.user_default);
        }
        if (entity != null) {
            if (entity.getComment() != null) {
                tv_content.setText(entity.getComment());
            } else {
                tv_content.setText("暂无内容");
            }
            tv_time.setText(TimeUtil.getDateHR(entity.getCreateTime()));
        }
    }

    @Override
    public int bindView(int viewtype) {
        return R.layout.teaching_study_more;
    }
}
