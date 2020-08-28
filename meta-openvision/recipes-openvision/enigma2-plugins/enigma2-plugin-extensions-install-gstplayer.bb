SUMMARY = "Meta package for installing gstplayer"
inherit allarch

require conf/license/license-gplv2.inc

RRECOMMENDS_${PN} = "gstplayer"

ALLOW_EMPTY_${PN} = "1"
