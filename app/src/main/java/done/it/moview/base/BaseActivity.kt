package done.it.moview.base

import android.support.v7.app.AppCompatActivity
import javax.inject.Inject

abstract class BaseActivity<P : MvpPresenter> : AppCompatActivity(), MvpView {

    @Inject lateinit var presenter: P
}