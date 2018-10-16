package lucascampos.modules.pullrequest.feature

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ViewFlipper
import lucascampos.modules.base.RetrofitConfig
import lucascampos.modules.base.extension.observe
import lucascampos.modules.pullrequest.R

private const val SHOW_CONTENT = 0
private const val SHOW_LOADER = 1
private const val SHOW_ERROR_STATE = 2

class PullRequestActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProviders
                .of(this,
                        PullRequestViewModelFactory(RetrofitConfig.api!!))
                .get(PullRequestViewModel::class.java)
    }

    private val pullRequests by lazy { findViewById<RecyclerView>(R.id.pull_requests) }
    private val viewFlipper by lazy { findViewById<ViewFlipper>(R.id.pull_request_screen) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pull_request)

        viewModel.apply {
            error.observe(this@PullRequestActivity) {
                viewFlipper.displayedChild = SHOW_ERROR_STATE
            }

            results.observe(this@PullRequestActivity) {
                viewFlipper.displayedChild = SHOW_CONTENT

                pullRequests.adapter = PullRequestAdapter(it)
                pullRequests.layoutManager = LinearLayoutManager(this@PullRequestActivity)
            }

            viewFlipper.displayedChild = SHOW_LOADER
            getPullRequests(intent.getStringExtra("owner"), intent.getStringExtra("title"))
        }
    }
}