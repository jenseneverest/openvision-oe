DESCRIPTION = "Multiboot flag tool by Persian Prince for Open Vision module."
LICENSE = "CLOSED"

SRC_URI = "file://multibootflag.zip"

S = "${WORKDIR}/multibootflag"

inherit upx_compress update-rc.d

INITSCRIPT_NAME = "multibootflag-loader"
INITSCRIPT_PARAMS = "start 05 S ."

do_compile() {
         ${CXX} multibootflag.cpp -o multibootflag
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/multibootflag ${D}${bindir}
	install -d ${D}${sysconfdir}/init.d/
	install -m 0755 ${S}/multibootflag-loader ${D}${sysconfdir}/init.d/
}

FILES_${PN} = "${bindir} ${sysconfdir}/init.d"
