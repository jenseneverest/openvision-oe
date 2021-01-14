FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-gstrtpmp4gpay-set-dafault-value-for-MPEG4-without-co.patch"

EXTRA_OEMESON += "\
	${GSTREAMER1_DEBUG} \
	${@bb.utils.contains("MACHINE", "dm800", "-Dtaglib=disabled", "", d)} \
	${@bb.utils.contains_any("MACHINE", "cube su980", "-Dc_std=gnu99", "", d)} \
	"

CFLAGS_append_cube = " -std=gnu99"
CFLAGS_append_su980 = " -std=gnu99"
