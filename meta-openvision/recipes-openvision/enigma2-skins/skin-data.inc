do_install() {
	cp -fr --preserve=links ${S}${prefix} ${D}/
}
