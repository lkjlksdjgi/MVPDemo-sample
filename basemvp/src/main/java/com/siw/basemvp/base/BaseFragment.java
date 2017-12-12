package com.siw.basemvp.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.siw.basemvp.utils.ReflexUtil;


/**
 * Created by 童思伟 on 2017/12/11.
 *
 */

public abstract class BaseFragment<P extends BasePresenter, M extends BaseModel> extends Fragment {
    protected P mPresenter;
    protected M mModel;
    protected Activity mActivity;
    protected Context mContext;
    public View view;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(view == null){
            view = inflater.inflate(getLayoutId(), null);
        }
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = ReflexUtil.getClazz(this, 0);
        mModel = ReflexUtil.getClazz(this, 1);
        if (this instanceof BaseView) {
            mPresenter.attachVM(this, mModel);
        }
        initUI(view,savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null){
            mPresenter.detachVM();
        }
    }
    /**
     * 获取view的id
     * @return
     */
    public abstract int getLayoutId();
    /**
     * 初始化控件
     */
    public abstract void initUI(View view, @Nullable Bundle savedInstanceState);
}
