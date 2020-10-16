package csoc.glgs.com.navigationexample

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.blankj.utilcode.util.Utils
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx
import kotlinx.android.synthetic.main.main1_fragment.*
import kotlinx.android.synthetic.main.main_fragment.*

/**
 * 作    者：MingMeng
 * 创建日期：2020/10/16
 * 描    述：
 */
class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewpager.initMain(this)
        mainBottom.init {
            when (it) {
                R.id.menu_main -> mainViewpager.setCurrentItem(0, false)
                R.id.menu_project -> mainViewpager.setCurrentItem(1, false)
                R.id.menu_system -> mainViewpager.setCurrentItem(2, false)
                R.id.menu_public -> mainViewpager.setCurrentItem(3, false)
                R.id.menu_me -> mainViewpager.setCurrentItem(4, false)
            }
        }
    }
    private fun ViewPager2.initMain(fragment: Fragment): ViewPager2 {
        //是否可滑动
        this.isUserInputEnabled = false
        this.offscreenPageLimit = 5
        //设置适配器
        adapter = object : FragmentStateAdapter(fragment) {
            override fun createFragment(position: Int): Fragment {
                when (position) {
                    0 -> {
                        return MainPage1Fragment()
                    }
                    1 -> {
                        return MainPage2Fragment()
                    }
                    2 -> {
                        return MainPage3Fragment()
                    }
                    3 -> {
                        return MainPage4Fragment()
                    }
                    4 -> {
                        return MainPage5Fragment()
                    }
                    else -> {
                        return MainPage1Fragment()
                    }
                }
            }
            override fun getItemCount() = 5
        }
        return this
    }
    fun BottomNavigationViewEx.init(navigationItemSelectedAction: (Int) -> Unit): BottomNavigationViewEx {
        enableAnimation(true)
        enableShiftingMode(false)
        enableItemShiftingMode(false)
        itemIconTintList = getColorStateList(ContextCompat.getColor(context, R.color.accent))
        itemTextColor =getColorStateList(ContextCompat.getColor(context, R.color.accent))
        setTextSize(12F)
        setOnNavigationItemSelectedListener {
            navigationItemSelectedAction.invoke(it.itemId)
            true
        }
        return this
    }
    fun getColorStateList(color: Int): ColorStateList {
        val colors = intArrayOf(color, ContextCompat.getColor(Utils.getApp(), R.color.colorGray))
        val states = arrayOfNulls<IntArray>(2)
        states[0] = intArrayOf(android.R.attr.state_checked, android.R.attr.state_checked)
        states[1] = intArrayOf()
        return ColorStateList(states, colors)
    }

}