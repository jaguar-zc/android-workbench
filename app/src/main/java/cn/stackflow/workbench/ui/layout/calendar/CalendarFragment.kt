package cn.stackflow.workbench.ui.layout.calendar

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import cn.stackflow.workbench.R
import cn.stackflow.workbench.common.base.BaseFragment
import cn.stackflow.workbench.common.calendarview.Article
import cn.stackflow.workbench.common.calendarview.ArticleAdapter
import cn.stackflow.workbench.common.calendarview.group.GroupItemDecoration
import cn.stackflow.workbench.databinding.CalendarFragmentBinding
import cn.stackflow.workbench.ui.layout.audit.AuditViewModel
import com.haibin.calendarview.Calendar
import com.haibin.calendarview.Calendar.Scheme
import com.haibin.calendarview.CalendarView
import kotlinx.android.synthetic.main.calendar_fragment.*
import kotlinx.android.synthetic.main.home_toolbar.*
import kotlinx.android.synthetic.main.menu_fragment.*
import kotlinx.android.synthetic.main.toolbar.view.*


/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class CalendarFragment(var text: String, var showToolbar: Boolean) :
    BaseFragment<AuditViewModel, CalendarFragmentBinding>(),
    CalendarView.OnCalendarSelectListener, CalendarView.OnYearChangeListener, View.OnClickListener {

    companion object {
        fun newInstance(text: String, showToolbar: Boolean = true): CalendarFragment {
            return CalendarFragment(
                text,
                showToolbar
            )
        }
    }

    private var mYear = 0

    override fun initData(savedInstanceState: Bundle?) {
        super.initData(savedInstanceState)

        toolbar.isVisible = showToolbar
        toolbar.tvTitle.setText(R.string.home_menu2)
        tv_month_day!!.setOnClickListener(View.OnClickListener {
            if (!calendarLayout!!.isExpand) {
                calendarLayout!!.expand()
                return@OnClickListener
            }
            calendarView!!.showYearSelectLayout(mYear)
            tv_lunar!!.visibility = View.GONE
            tv_year!!.visibility = View.GONE
            tv_month_day!!.text = mYear.toString()
        })
        fl_current.setOnClickListener(View.OnClickListener { calendarView!!.scrollToCurrent() })
        calendarView!!.setOnCalendarSelectListener(this)
        calendarView!!.setOnYearChangeListener(this)
        tv_year!!.text = calendarView!!.curYear.toString()
        mYear = calendarView!!.curYear
        tv_month_day!!.text = calendarView!!.curMonth.toString() + "月" + calendarView!!.curDay + "日"
        tv_lunar!!.text = "今日"
        tv_current_day!!.text = calendarView!!.curDay.toString()


        val year: Int = calendarView.curYear
        val month: Int = calendarView.curMonth

        val map: MutableMap<String, Calendar?> =
            HashMap()
        map[getSchemeCalendar(year, month, 3, -0xbf24db, "假").toString()] =
            getSchemeCalendar(year, month, 3, -0xbf24db, "假")
        map[getSchemeCalendar(year, month, 6, -0x196ec8, "事").toString()] =
            getSchemeCalendar(year, month, 6, -0x196ec8, "事")
        map[getSchemeCalendar(year, month, 9, -0x20ecaa, "议").toString()] =
            getSchemeCalendar(year, month, 9, -0x20ecaa, "议")
        map[getSchemeCalendar(year, month, 13, -0x123a93, "记").toString()] =
            getSchemeCalendar(year, month, 13, -0x123a93, "记")
        map[getSchemeCalendar(year, month, 14, -0x123a93, "记").toString()] =
            getSchemeCalendar(year, month, 14, -0x123a93, "记")
        map[getSchemeCalendar(year, month, 15, -0x5533bc, "假").toString()] =
            getSchemeCalendar(year, month, 15, -0x5533bc, "假")
        map[getSchemeCalendar(year, month, 18, -0x43ec10, "记").toString()] =
            getSchemeCalendar(year, month, 18, -0x43ec10, "记")
        map[getSchemeCalendar(year, month, 25, -0xec5310, "假").toString()] =
            getSchemeCalendar(year, month, 25, -0xec5310, "假")
        map[getSchemeCalendar(year, month, 27, -0xec5310, "多").toString()] =
            getSchemeCalendar(year, month, 27, -0xec5310, "多")
        //此方法在巨大的数据量上不影响遍历性能，推荐使用
        //此方法在巨大的数据量上不影响遍历性能，推荐使用
        calendarView.setSchemeDate(map)


        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(GroupItemDecoration<String, Article>())
        recyclerView.adapter = ArticleAdapter(context)
        recyclerView.notifyDataSetChanged()

    }

    private fun getSchemeCalendar(
        year: Int,
        month: Int,
        day: Int,
        color: Int,
        text: String
    ): Calendar? {
        val calendar = Calendar()
        calendar.year = year
        calendar.month = month
        calendar.day = day
        calendar.schemeColor = color //如果单独标记颜色、则会使用这个颜色
        calendar.scheme = text
        calendar.addScheme(Scheme())
        calendar.addScheme(-0xff7800, "假")
        calendar.addScheme(-0xff7800, "节")
        return calendar
    }


    override fun getLayoutId(): Int {
        return R.layout.calendar_fragment
    }

    override fun onCalendarSelect(calendar: Calendar?, isClick: Boolean) {
        tv_lunar.visibility = View.VISIBLE;
        tv_year.visibility = View.VISIBLE;
        if (calendar != null) {
            tv_month_day.text = (String.format("%s%s%s%s", calendar?.month, "月", calendar.day, "日"))
        }
        tv_year.text = (String.format("%s", calendar?.year));
        tv_lunar.text = (calendar?.lunar);
        mYear = calendar?.year!!;
    }

    override fun onCalendarOutOfRange(calendar: Calendar?) {
    }

    override fun onYearChange(year: Int) {
        tv_month_day.text = String.format("%s", year);
    }

    override fun onClick(v: View?) {
    }
}