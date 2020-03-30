DESCRIPTION = "Tuxbox common"

require conf/license/openvision-gplv2.inc

inherit allarch

FILES_${PN} = "/"

do_compile() {
	true
}

do_install() {
	install -m 0755 -d "${D}${sysconfdir}"
	install -m 0755 -d "${D}${sysconfdir}/tuxbox"
	install -m 0755 -d "${D}${sysconfdir}/tuxbox/scce"
	install -m 0755 -d "${D}/usr/keys"
	install -m 0755 -d "${D}${bindir}"
	install -m 0755 -d "${D}/var"

	ln -s "${sysconfdir}/tuxbox/scce"	"${D}/var/"
	ln -s "/usr/keys"			"${D}/var/"
	ln -s "${bindir}"			"${D}/var/"
	ln -s "${sysconfdir}"			"${D}/var/"
}
