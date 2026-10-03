package com.nexa.app;

import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    LinearLayout content;
    TextView title;

    int dp(float v) { return (int)(v * getResources().getDisplayMetrics().density + .5f); }

    @Override public void onCreate(Bundle b) {
        super.onCreate(b);
        showHome();
    }

    TextView text(String s, float size) {
        TextView t = new TextView(this);
        t.setText(s); t.setTextSize(size); t.setTextColor(Color.rgb(25,25,25));
        t.setPadding(dp(16), dp(10), dp(16), dp(10));
        return t;
    }

    Button navButton(String label) {
        Button b = new Button(this);
        b.setText(label); b.setAllCaps(false);
        return b;
    }

    void base(String screenTitle) {
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setBackgroundColor(Color.rgb(247,247,247));

        title = text(screenTitle, 24);
        title.setGravity(Gravity.CENTER_VERTICAL);
        root.addView(title, new LinearLayout.LayoutParams(-1, dp(64)));

        content = new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL);
        ScrollView scroll = new ScrollView(this);
        scroll.addView(content);
        root.addView(scroll, new LinearLayout.LayoutParams(-1, 0, 1));

        LinearLayout nav = new LinearLayout(this);
        nav.setGravity(Gravity.CENTER);
        String[] labels = {"Home","Jobs","Create","Messages","Profile"};
        for (String l: labels) {
            Button n = navButton(l);
            n.setOnClickListener(v -> {
                if (l.equals("Home")) showHome();
                else if (l.equals("Jobs")) showJobs();
                else if (l.equals("Create")) showCreate();
                else if (l.equals("Messages")) showMessages();
                else showProfile();
            });
            nav.addView(n, new LinearLayout.LayoutParams(0, dp(58), 1));
        }
        root.addView(nav);
        setContentView(root);
    }

    void showHome() {
        base("NEXA");
        content.addView(text("Your world. Your opportunities.", 20));
        content.addView(card("Welcome to NEXA", "Social networking and opportunities in one place."));
        content.addView(card("Community", "Posts, photos, short videos, likes, comments and shares."));
        content.addView(card("Opportunities", "Discover jobs and apply using your NEXA profile."));
        content.addView(card("Safety", "Account security, reporting and moderation are built into the platform."));
    }

    void showJobs() {
        base("Jobs");
        content.addView(text("Find opportunities", 20));
        content.addView(card("Remote Software Assistant", "Remote • Skills-based application"));
        content.addView(card("Marketing Intern", "Windhoek • Entry level"));
        content.addView(card("Graphic Designer", "Remote • Portfolio requested"));
        Button post = navButton("Post a job");
        post.setOnClickListener(v -> Toast.makeText(this, "Employer job-posting flow will connect to the backend.", Toast.LENGTH_SHORT).show());
        content.addView(post);
    }

    void showCreate() {
        base("Create");
        EditText post = new EditText(this);
        post.setHint("What's happening?");
        post.setMinLines(5);
        content.addView(post);
        Button publish = navButton("Publish");
        publish.setOnClickListener(v -> Toast.makeText(this, "The post will be sent to the NEXA backend.", Toast.LENGTH_SHORT).show());
        content.addView(publish);
    }

    void showMessages() {
        base("Messages");
        content.addView(card("Messages", "Private messaging foundation. Real-time messaging will connect to the secure backend."));
        content.addView(card("Notifications", "Likes, comments, applications and account alerts will appear here."));
    }

    void showProfile() {
        base("Profile");
        content.addView(text("Your NEXA profile", 20));
        content.addView(card("Profile", "Name, bio, skills, portfolio and availability for work."));
        content.addView(card("Account", "Secure login, sessions and account controls."));
        content.addView(card("Employer tools", "Business profile, verification and job management."));
    }

    View card(String heading, String body) {
        LinearLayout box = new LinearLayout(this);
        box.setOrientation(LinearLayout.VERTICAL);
        box.setBackgroundColor(Color.WHITE);
        TextView h = text(heading, 18);
        TextView b = text(body, 15);
        box.addView(h); box.addView(b);
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(-1, -2);
        p.setMargins(dp(12), dp(8), dp(12), dp(8));
        box.setLayoutParams(p);
        return box;
    }
}