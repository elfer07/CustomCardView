package ar.com.customcardview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import ar.com.customcardview.databinding.CardViewDialogBinding

class CustomCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : CardView(context, attrs, defStyle), OnClickListener {

    var buttonClick : OnClickListener? = null

    private var binding = CardViewDialogBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        initAttrs(attrs)

    }

    private fun initAttrs(attrs: AttributeSet?) {
        attrs?.let {

            val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CardViewDialog)

            try {
                if (typedArray.hasValue(R.styleable.CardViewDialog_titleCardDialog)) {
                    binding.tvTitle.text = typedArray.getText(R.styleable.CardViewDialog_titleCardDialog)
                }

                if (typedArray.hasValue(R.styleable.CardViewDialog_messageCardDialog)) {
                    binding.tvMessage.text = typedArray.getText(R.styleable.CardViewDialog_messageCardDialog)
                }

                if (typedArray.hasValue(R.styleable.CardViewDialog_titleButton)) {
                    binding.btnAction.text = typedArray.getText(R.styleable.CardViewDialog_titleButton)
                }


            } finally {
                typedArray.recycle()
            }
        }
    }

    override fun onButtonClickListener() {
        binding.btnAction.setOnClickListener(buttonClick)
    }
}