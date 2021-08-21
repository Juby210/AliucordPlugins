package com.aliucord.plugins.hidebloat.patchers;

import com.aliucord.plugins.hidebloat.patchers.base.BasePatcher;
import com.aliucord.plugins.hidebloat.util.Const;
import com.aliucord.plugins.hidebloat.util.Util;
import com.discord.databinding.WidgetUserSheetBinding;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.discord.widgets.user.usersheet.WidgetUserSheetViewModel;

import top.canyie.pine.Pine;

public class NotesPatch extends BasePatcher {

    public NotesPatch() throws Exception {
        super(Const.Key.NOTES_KEY, Const.ViewName.NOTES_NAME, WidgetUserSheet.class.getDeclaredMethod("configureNote", WidgetUserSheetViewModel.ViewState.Loaded.class));
    }

    @Override
    public void patchBody(Pine.CallFrame callFrame) {
        WidgetUserSheetBinding binding = WidgetUserSheet.access$getBinding$p((WidgetUserSheet) callFrame.thisObject);

        Util.hideViewCompletely(binding.w);
        Util.hideViewCompletely(binding.x);
        Util.hideViewCompletely(binding.y);
    }
}
