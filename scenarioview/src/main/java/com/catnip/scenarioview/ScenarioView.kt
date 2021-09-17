package com.catnip.scenarioview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.catnip.scenarioview.databinding.LayoutComponentScenarioViewBinding

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class ScenarioView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding = LayoutComponentScenarioViewBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        inflate(context, R.layout.layout_component_scenario_view, this)
    }


    var state : ScenarioState = ScenarioState.NORMAL
        set(value) {
            when(value){
                ScenarioState.NORMAL -> {
                    binding.groupErrorLayout.visibility = GONE
                    binding.pbScenarioViewLoading.visibility = GONE
                }
                ScenarioState.LOADING -> {
                    binding.groupErrorLayout.visibility = GONE
                    binding.pbScenarioViewLoading.visibility = VISIBLE
                }
                ScenarioState.ERROR_NO_CONNECTION -> {
                    binding.groupErrorLayout.visibility = VISIBLE
                    binding.pbScenarioViewLoading.visibility = GONE
                    binding.ivScenarioViewIcon.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_error_no_connection))
                    binding.tvScenarioViewText.text = context.getString(R.string.text_error_no_connection)
                }
                ScenarioState.ERROR_GENERAL -> {
                    binding.groupErrorLayout.visibility = VISIBLE
                    binding.pbScenarioViewLoading.visibility = GONE
                    binding.ivScenarioViewIcon.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_error_general))
                    binding.tvScenarioViewText.text = context.getString(R.string.text_error_general)
                }
                ScenarioState.ERROR_DATA_EMPTY -> {
                    binding.groupErrorLayout.visibility = VISIBLE
                    binding.pbScenarioViewLoading.visibility = GONE
                    binding.ivScenarioViewIcon.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_error_no_data))
                    binding.tvScenarioViewText.text = context.getString(R.string.text_error_no_data)
                }
            }
            field = value
        }
}