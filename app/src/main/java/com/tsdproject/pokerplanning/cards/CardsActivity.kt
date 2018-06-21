package com.tsdproject.pokerplanning.cards

import android.content.Intent
import android.os.Bundle
import com.azoft.carousellayoutmanager.CenterScrollListener
import com.tsdproject.pokerplanning.R
import com.tsdproject.pokerplanning.base.BaseActivity
import com.tsdproject.pokerplanning.base.BasePresenter
import com.tsdproject.pokerplanning.results.ResultsActivity
import kotlinx.android.synthetic.main.activity_cards.*

class CardsActivity : BaseActivity(), CardsView {

    private lateinit var presenter: CardsPresenter
    private lateinit var cardsAdapter: CardsAdapter

    override fun providePresenter(): BasePresenter? {
        return presenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards)
        presenter = CardsPresenterImpl(this)
        setupSwitch()
    }

    override fun onStart() {
        super.onStart()
        setupCarouselView()
    }

    private fun setupCarouselView() {
        cardsRecyclerView.layoutManager = presenter.getCarouselLayoutManager()
        cardsRecyclerView.setHasFixedSize(true)
        cardsAdapter = CardsAdapter()
        cardsRecyclerView.adapter = cardsAdapter
        cardsRecyclerView.addOnScrollListener(CenterScrollListener())
    }

    private fun setupSwitch() {
        readySwitch.setOnCheckedChangeListener { view, checked ->
            if (checked) {
                startActivity(Intent(this, ResultsActivity::class.java))
            }
        }
    }

    override fun onChooseCardClick(cardValue: Int){
        setCarousleScrollable(false)
        presenter.sendAnswer(cardValue)
    }

    override fun setCarousleScrollable(isScrollable: Boolean) {
        presenter.canScrollHorizontally = isScrollable
    }
}
