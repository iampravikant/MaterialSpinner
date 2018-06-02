/*
 * MIT License
 *
 * Copyright (c) 2018 Pramod Ravikant
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.pravikant.materialspinner

import android.content.Context
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.ms_material_spinner.view.*

class MaterialSpinner : LinearLayout {

    private var hint: String? = null
    private var hintColor: Int? = null
    private var lineColor: Int? = null
    private var textSize: Int? = null

    constructor(context: Context) : super(context) {
        init(null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(attrs)
    }

    private fun init(attrs: AttributeSet?) {
        LayoutInflater.from(context).inflate(R.layout.ms_material_spinner, this, true)

        if (attrs == null) throw Exception("Provide hint for the Spinner")

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.MaterialSpinner)

        hint = typedArray.getString(R.styleable.MaterialSpinner_ms_hint)
        hintColor = typedArray.getColor(R.styleable.MaterialSpinner_ms_hint_color, ContextCompat.getColor(context, R.color.ms_colorHint))
        lineColor = typedArray.getColor(R.styleable.MaterialSpinner_ms_line_color, ContextCompat.getColor(context, R.color.ms_colorHint))
        textSize = typedArray.getDimensionPixelSize(R.styleable.MaterialSpinner_ms_text_size, context.resources.getDimensionPixelSize(R.dimen.ms_text_size))
        typedArray.recycle()

        initData()
    }

    private fun initData() {
        ms_hint.text = hint
        ms_hint.setTextColor(hintColor!!)
        ms_line.setBackgroundColor(lineColor!!)
    }

    /**
     * Set hint text
     *
     * @param hint String
     **/
    fun setHint(hint: String) {
        this@MaterialSpinner.hint = hint
        initData()
    }

    /**
     * Set Spinner adapter
     *
     * @param adapter A SpinnerAdapter
     **/
    fun setAdapter(adapter: SpinnerAdapter) {
        ms_spinner.adapter = adapter
    }

    /**
     * Set Spinner items. Only if items are String Array. For custom items, use setAdapter(...)
     *
     * @param items String Array
     **/
    fun setItems(items: Array<String>) {
        val adapter = StringArrayAdapter(context, items, textSize!!)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        setAdapter(adapter)
    }

    /**
     * Set hint text color
     *
     * @param hintColor A Color
     **/
    fun setHintColor(hintColor: Int) {
        this@MaterialSpinner.hintColor = hintColor
        initData()
    }

    /**
     * Set the color of the line below the text
     *
     * @param lineColor A Color
     **/
    fun setLineColor(lineColor: Int) {
        this@MaterialSpinner.lineColor = lineColor
        initData()
    }

    /**
     * Returns Spinner object. This can be used to set listeners etc.
     *
     * @return Spinner
     **/
    fun getSpinner(): Spinner = ms_spinner

    /**
     * Returns current selected item in the Spinner
     *
     * @return Object
     **/
    fun getSelectedItem() = ms_spinner.selectedItem

    private class StringArrayAdapter(context: Context, items: Array<String>, val textSize: Int) : ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, items) {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val view = super.getView(position, convertView, parent)
            view.setPadding(context.resources.getDimensionPixelSize(R.dimen.ms_text_margin), 0, 0, 0)
            (view as TextView).setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize.toFloat())
            return view
        }
    }
}
